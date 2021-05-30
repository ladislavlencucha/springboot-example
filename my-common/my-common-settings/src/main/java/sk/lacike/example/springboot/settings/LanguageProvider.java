package sk.lacike.example.springboot.settings;

import java.util.Set;

public interface LanguageProvider {

	Set<SystemLanguage> getSystemLanguages();

}
