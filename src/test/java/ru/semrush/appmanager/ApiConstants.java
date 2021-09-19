package ru.semrush.appmanager;

import static ru.semrush.appmanager.ApiConstants.Servers.*;
import static ru.semrush.appmanager.ApiConstants.Path.*;

public class ApiConstants {
    public static class RunVariable {
        public static String server = SEMRUSH_URL;
        public static String path = SEMRUSH_PATH;
    }

    public static class Servers {
        public static String SEMRUSH_URL = "https://www.semrush.com/";
    }

    public static class Path {
        public static String SEMRUSH_PATH = "blog/";
    }
}
