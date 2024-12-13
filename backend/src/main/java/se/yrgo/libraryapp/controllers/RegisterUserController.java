package se.yrgo.libraryapp.controllers;

import javax.inject.Inject;
import io.jooby.annotations.GET;
import io.jooby.annotations.POST;
import io.jooby.annotations.Path;
import io.jooby.annotations.QueryParam;
import org.apache.commons.text.StringEscapeUtils;
import se.yrgo.libraryapp.dao.UserDao;
import se.yrgo.libraryapp.entities.forms.RegisterUserData;
import se.yrgo.libraryapp.validators.RealName;
import se.yrgo.libraryapp.validators.Username;


@Path("/register")
public class RegisterUserController {
    private UserDao userDao;

    @Inject
    RegisterUserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @POST
    public boolean register(RegisterUserData userData) {
        String sanitizedRealName = StringEscapeUtils.escapeHtml4(userData.getRealName());
        String sanitizedName = StringEscapeUtils.escapeHtml4(userData.getName());

        if (Username.validate(sanitizedName) && RealName.validate(sanitizedRealName)) {
            return userDao.register(sanitizedName, sanitizedRealName, userData.getPassword());
        }

        return false;
    }

    @GET
    @Path("/available")
    public boolean isNameAvailable(@QueryParam String name) {
        return userDao.isNameAvailable(name);
    }
}
