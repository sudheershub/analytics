package org.sudheershub.analytics.analytics.web.listener;

import br.com.jarch.annotation.JArchJsfEventAfter;
import br.com.jarch.annotation.JArchJsfEventRestoreView;
import br.com.jarch.model.UserInformation;
import br.com.jarch.util.BundleUtils;
import br.com.jarch.util.JavaScriptUtils;

import javax.enterprise.event.Observes;
import javax.faces.event.PhaseEvent;
import javax.servlet.http.HttpSession;

public class SessionExpiredJsfListener {

    private final void verificaSessaoExpirada(@Observes @JArchJsfEventAfter @JArchJsfEventRestoreView PhaseEvent event, UserInformation userInformation) {

        boolean login = event.getFacesContext().getViewRoot().getViewId().contains("/login.xhtml");
        HttpSession session = ((HttpSession) event.getFacesContext().getExternalContext().getSession(false));

        if ((session == null && !login)
            || (session != null && session.isNew())
            || (!login && !userInformation.exists())) {
            JavaScriptUtils.showMessageBodyErrorRedirect("../login/login.jsf",
                BundleUtils.messageBundle("message.sessaoExpirada"),
                BundleUtils.messageBundle("message.sessaoExpirada"));
        }
    }
}
