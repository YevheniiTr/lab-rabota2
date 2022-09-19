package com.example.kp_db.Class;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;

import java.io.IOException;

public class PDFfont {
    private static final String FONT = "C:\\Users\\Yevhenii\\IdeaProjects\\kp_db\\TNR.ttf";

    public static Font getFont() {
        BaseFont baseFont = null;
        try {
            baseFont = BaseFont.createFont(FONT, BaseFont.IDENTITY_H, true);
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
        return new Font(baseFont);
    }
}
