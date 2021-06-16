package sk.lacike.example.springboot.settings;

import lombok.Data;

@Data
public class SystemLanguageImpl implements SystemLanguage {

	private final String code;
	private final String name;

}
