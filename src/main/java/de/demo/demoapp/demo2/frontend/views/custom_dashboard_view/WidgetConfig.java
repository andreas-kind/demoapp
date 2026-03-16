package de.demo.demoapp.demo2.frontend.views.custom_dashboard_view;

public class WidgetConfig {
    public enum WidgetType {
        WIDGET_1("Widget 1"),
        WIDGET_2("Widget 2"),
        WIDGET_3("Widget 3"),
        WIDGET_4("Widget 4"),
        WIDGET_5("Widget 5"),
        WIDGET_6("Widget 6"),
        WIDGET_7("Widget 7");

        private final String label;

        WidgetType(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }

    private WidgetType type;
    private int colspan;
    private int rowspan;

    public WidgetConfig() {
    }

    public WidgetConfig(WidgetType type, int colspan, int rowspan) {
        this.type = type;
        this.colspan = colspan;
        this.rowspan = rowspan;
    }

    public WidgetType getType() {
        return type;
    }

    public void setType(WidgetType type) {
        this.type = type;
    }

    public int getColspan() {
        return colspan;
    }

    public void setColspan(int colspan) {
        this.colspan = colspan;
    }

    public int getRowspan() {
        return rowspan;
    }

    public void setRowspan(int rowspan) {
        this.rowspan = rowspan;
    }
}
