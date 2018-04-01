package ru.sb.statistics.controller.security;

import org.springframework.web.bind.annotation.RequestMapping;
import ru.sb.statistics.controller.rest.base.BaseAjaxController;
import ru.sb.statistics.model.User;

//@RestController
@RequestMapping("/login/users")
public class UserController extends BaseAjaxController<User>{
}
