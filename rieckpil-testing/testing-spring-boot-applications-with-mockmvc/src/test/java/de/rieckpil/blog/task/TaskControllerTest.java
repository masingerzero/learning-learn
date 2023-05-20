package de.rieckpil.blog.task;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TaskController.class)
class TaskControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService taskService;


    @Test
    public void shouldRejectCreatingReviewsWhenUserIsAnonymous() throws Exception {
        this.mockMvc.perform(post("/api/task")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"taskTitle\":\"some task title\"}")
                        .with(csrf()))
                .andExpect(status().isUnauthorized());
    }



    @Test
    public void shouldReturnLocationOfReviewWhenUserIsAuthenticatedAndCreatesReview() throws Exception {
        when(taskService.createTask(anyString())).thenReturn(1000L);

        this.mockMvc.perform(post("/api/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"taskTitle\":\"some task title\"}")
                        .with(SecurityMockMvcRequestPostProcessors.csrf())
                        .with(SecurityMockMvcRequestPostProcessors.user("duke")))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Location", containsString("1000")));

    }

    @Test
    public void shouldAllowDeletingReviewsWhenUserIsAdmin() throws Exception {
        this.mockMvc.perform(
                delete("/api/tasks/10")
                        .with(csrf())
                        .with(user("fooUser").roles("ADMIN", "SUPER_USER"))
        ).andExpect(status().isOk());

        verify(taskService).deleteTask(10L);
    }

    @Test
    @WithMockUser(username = "juanfe")
    public void shouldRejectDeletingReviewsWhenUserIsNotAdmin() throws Exception {
        this.mockMvc.perform(
                delete("/api/tasks/10")
                        .with(csrf())
        ).andExpect(status().isForbidden());


    }
}