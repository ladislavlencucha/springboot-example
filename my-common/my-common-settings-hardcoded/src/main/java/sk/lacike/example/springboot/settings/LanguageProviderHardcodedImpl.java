package sk.lacike.example.springboot.settings;

import java.util.Set;

import com.google.common.collect.ImmutableSet;
import org.springframework.stereotype.Component;

@Component
public class LanguageProviderHardcodedImpl implements LanguageProvider {

	@Override
	public Set<SystemLanguage> getSystemLanguages() {
		return ImmutableSet.of(new SystemLanguageImpl("en-us", "English (US)"));
	}
}
