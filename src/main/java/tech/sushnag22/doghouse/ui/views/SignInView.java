package tech.sushnag22.doghouse.ui.views;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import tech.sushnag22.doghouse.backend.service.UserService;
import tech.sushnag22.doghouse.ui.components.SignInForm;

@Route("")
public class SignInView  extends VerticalLayout {
    private UserService userService;

    public SignInView(UserService userService) {
        this.userService = userService;
        SignInForm signInForm = new SignInForm(userService);
        H2 header = new H2("Sign in");
        HorizontalLayout horizontalLayout = new HorizontalLayout(signInForm);

        horizontalLayout.setWidthFull();
        horizontalLayout.setAlignItems(Alignment.CENTER);
        horizontalLayout.setJustifyContentMode(JustifyContentMode.CENTER);

        setHeightFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        setHorizontalComponentAlignment(Alignment.CENTER, header);

        add(header, horizontalLayout);
    }
}