package com.demoproject.util;

import java.io.File;
import java.io.IOException;

public class Course {
    private static String UPLOADED_FOLDER = "src/main/resources/static/images/kk.jpg";

    public static void main(String[] args) {
        File file = new File(UPLOADED_FOLDER);
        file.delete();
    }


}

