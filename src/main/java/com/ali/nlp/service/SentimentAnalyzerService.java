package com.ali.nlp.service;

import com.ali.nlp.payload.TextDto;

public interface SentimentAnalyzerService {
    int analyse(TextDto dto);
}
