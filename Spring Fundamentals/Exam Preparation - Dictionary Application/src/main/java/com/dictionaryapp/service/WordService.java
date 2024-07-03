package com.dictionaryapp.service;

import com.dictionaryapp.config.UserSession;
import com.dictionaryapp.model.dto.AddWordDTO;
import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.model.enums.LanguageEnum;
import com.dictionaryapp.repo.LanguageRepository;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.repo.WordRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class WordService {
    private final LanguageRepository languageRepository;
    private final UserRepository userRepository;
    private final UserSession userSession;
    private final WordRepository wordRepository;

    public WordService(LanguageRepository languageRepository, UserRepository userRepository, UserSession userSession, WordRepository wordRepository) {
        this.languageRepository = languageRepository;
        this.userRepository = userRepository;
        this.userSession = userSession;
        this.wordRepository = wordRepository;
    }

    public boolean addWord(AddWordDTO addWordDTO) {
        if (!userSession.isUserLoggedIn()) {
            return false;
        }

        Optional<User> owner = userRepository.findByUsername(userSession.username());
        if (owner.isEmpty()) {
            return false;
        }

        Optional<Language> languageByName = languageRepository.findByName(addWordDTO.getLanguage());
        if (languageByName.isEmpty()) {
            return false;
        }

        Word word = new Word();
        word.setTerm(addWordDTO.getTerm());
        word.setTranslation(addWordDTO.getTranslation());
        word.setExample(addWordDTO.getExample());
        word.setInputDate(addWordDTO.getInputDate());
        word.setAddedBy(owner.get());
        word.setLanguage(languageByName.get());

        wordRepository.save(word);

        return true;
    }

    public Map<LanguageEnum, List<Word>> getAllWords() {
        Map<LanguageEnum, List<Word>> result = new HashMap<>();
        List<Language> languages = languageRepository.findAll();

        for (Language language : languages) {
            List<Word> words = wordRepository.findByLanguage(language);

            result.put(language.getName(), words);
        }

        return result;
    }
}
