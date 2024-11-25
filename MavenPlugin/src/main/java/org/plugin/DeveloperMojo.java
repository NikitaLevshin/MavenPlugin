package org.plugin;

import org.apache.maven.model.Developer;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.util.List;

@Mojo(name = "show-devs")
public class DeveloperMojo extends AbstractMojo {

    @Parameter(defaultValue = "${project}", readonly = true)
    private MavenProject mavenProject;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        List<Developer> developers = mavenProject.getDevelopers();

        if (developers.isEmpty()) {
            getLog().info("No developers found");
        } else {
            for (Developer developer : developers) {
                getLog().info("Dev id: " + developer.getId());
                getLog().info("Name: " + developer.getName());
                getLog().info("Email: " + developer.getEmail());
                getLog().info("Organization: " + developer.getOrganization());
                getLog().info("Roles: " + developer.getRoles());
                getLog().info("TimeZone: " + developer.getTimezone());
            }
        }
    }
}
