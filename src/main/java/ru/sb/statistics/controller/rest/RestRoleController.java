package ru.sb.statistics.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sb.statistics.controller.rest.base.BaseAjaxController;
import ru.sb.statistics.model.Role;

@RestController
@RequestMapping("/rest/roles")
public class RestRoleController extends BaseAjaxController<Role> {

}
