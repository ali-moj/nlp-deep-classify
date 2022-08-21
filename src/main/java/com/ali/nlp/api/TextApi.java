package com.ali.nlp.api;

import com.ali.nlp.payload.TextDto;
import com.ali.nlp.service.SentimentAnalyzerService;
import com.ali.nlp.util.SentimentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nlp")
public class TextApi {

    @Autowired
    private SentimentAnalyzerService sentimentAnalyzerService;

    @CrossOrigin
    @PostMapping(value = "/analyse")
    @ResponseBody
    public ResponseEntity<?> analyse(@RequestBody TextDto dto) {
        int analyse = sentimentAnalyzerService.analyse(dto);
        final SentimentType fromValue = SentimentType.fromValue(analyse);
        return ResponseEntity.ok(fromValue);
    }
}
