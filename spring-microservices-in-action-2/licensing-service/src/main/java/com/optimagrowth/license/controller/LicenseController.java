package com.optimagrowth.license.controller;

import com.optimagrowth.license.LicensingServiceApplication;
import com.optimagrowth.license.model.License;
import com.optimagrowth.license.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "v1/organization/{organizationId}/license")
public class LicenseController {
    @Autowired
    LicenseService licenseService;

    @GetMapping(value = "/{licenseId}")
    public ResponseEntity<License> getLicense(@PathVariable("organizationId") String organizationId,
                                              @PathVariable("licenseId") String licenseId) {
        License license = licenseService.getLicense(organizationId, licenseId);
        license.add(
                linkTo(methodOn(LicenseController.class).
                        getLicense(organizationId, license.getLicenseId())).withSelfRel(),

                linkTo(methodOn(LicenseController.class).
                        addLicense(license, organizationId, null)).withRel("addLicense"),

                linkTo(methodOn(LicenseController.class).
                        updateLicense(license, organizationId)).withRel("updateLicense"),

                linkTo(methodOn(LicenseController.class).
                        deleteLicense(licenseId, organizationId)).withRel("deleteLicense")

        );

        LicenseController licenseController = methodOn(LicenseController.class);


        return ResponseEntity.ok(license);
    }

    @PutMapping
    public ResponseEntity<String> updateLicense(@RequestBody License request,
                                                @PathVariable("organizationId") String organizationId) {
        String message = licenseService.updateLicense(request, organizationId);
        return ResponseEntity.ok(message);
    }

    @PostMapping
    public ResponseEntity<String> addLicense(@RequestBody License request,
                                             @PathVariable("organizationId") String organizationId,
                                             @RequestHeader(value = "Accept-Language", required = false) Locale locale) {
        String message = licenseService.createLicense(request, organizationId, locale);
        return ResponseEntity.ok(message);
    }

    @DeleteMapping(value = "/{licenseId}")
    public ResponseEntity<String> deleteLicense(@PathVariable("licenseId") String licenseId,
                                                @PathVariable("organizationId") String organizationId) {
        String message = licenseService.deleteLicense(licenseId, organizationId);
        return ResponseEntity.ok(message);
    }
}
