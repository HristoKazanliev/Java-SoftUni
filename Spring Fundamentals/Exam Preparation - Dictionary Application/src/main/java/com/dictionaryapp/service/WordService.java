package com.dictionaryapp.service;

import com.dictionaryapp.config.UserSession;
import com.dictionaryapp.model.dto.AddWordDTO;
import com.dictionaryapp.repo.LanguageRepository;
import com.dictionaryapp.repo.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class WordService {
    private final LanguageRepository languageRepository;
    private final UserRepository userRepository;
    private final UserSession userSession;

    public WordService(LanguageRepository languageRepository, UserRepository userRepository, UserSession userSession) {
        this.languageRepository = languageRepository;
        this.userRepository = userRepository;
        this.userSession = userSession;
    }

    public void addWord(AddWordDTO addWordDTO) {

    }
}
