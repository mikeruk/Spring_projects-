package cv.opencv5.web;

import org.springframework.web.servlet.ModelAndView;

public abstract class BaseController {

    //    This class IS NOT IMPLEMENTED ANYWHERE  !!!
    //    It can be implemented later to improve the project.


    public ModelAndView view(String viewName, ModelAndView modelAndView) {
        modelAndView.setViewName(viewName);

        return modelAndView;
    }

    public ModelAndView view(String viewName) {
        return this.view(viewName, new ModelAndView());
    }

    public ModelAndView redirect(String url) {
        return this.view("redirect:" + url);
    }
}
