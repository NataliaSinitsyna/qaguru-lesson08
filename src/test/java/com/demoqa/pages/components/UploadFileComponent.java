package com.demoqa.pages.components;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class UploadFileComponent {

    public void uploadFile(String value) {
        File file = new File(String.format("src/test/resources/%s", value));
        $("#uploadPicture").uploadFile(file);
    }

}
