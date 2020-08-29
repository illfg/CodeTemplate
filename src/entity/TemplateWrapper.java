package entity;

public class TemplateWrapper {
    String template_name;
    String content;
    int id;

    public TemplateWrapper() {
        this.template_name = template_name;
        this.content = content;
        this.id = id;
    }

    public TemplateWrapper(String template_name, int id) {
        this.template_name = template_name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTemplate_name() {
        return template_name;
    }

    public void setTemplate_name(String template_name) {
        this.template_name = template_name;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
