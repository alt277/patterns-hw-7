package ru.geekbrains.controller;

import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.service.PictureService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log
@Controller
@RequestMapping("/picture")
public class PictureController {


    private final PictureService pictureService;

    @Autowired
    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }


        @GetMapping("/{pictureId}")
    public void downloadProductPicture(@PathVariable("pictureId") Long pictureId, HttpServletResponse resp) throws IOException {

            LoggerFactory.getLogger(PictureController.class)
                    .info("Downloading picture with id: {}", pictureId);

      pictureService.downloadProductPicture(pictureId, resp);
    }

    @GetMapping("/{pictureId}/delete")
    public String deleteProductPicture(@PathVariable("pictureId") Long pictureId) throws IOException {

        LoggerFactory.getLogger(PictureController.class)
                .info("Deleting picture with id: {}", pictureId);
        pictureService.deleteProductPicture(pictureId );

        return "redirect:/product/{id}/edit (pictureId = ${pict.id}";
    }
}
