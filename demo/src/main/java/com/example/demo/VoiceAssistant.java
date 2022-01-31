package com.example.demo;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;


public class VoiceAssistant {

	public static void main(String[] args) {
		
		Configuration config = new Configuration();
		
		
		config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		
		// setting path of dictionary and language by use this link  (http://www.speech.cs.cmu.edu/tools/lmtool-new.html)
		config.setDictionaryPath("src\\main\\resources\\7012.dic");
		config.setLanguageModelPath("src\\main\\resources\\7012.lm");
		
		try {
			LiveSpeechRecognizer speech = new LiveSpeechRecognizer(config);
			speech.startRecognition(true);   // starting mic 
			
			SpeechResult speechResult = null ;
			
			while((speechResult = speech.getResult()) !=null) {
				
				String voiceCommand = speechResult.getHypothesis();
				System.out.println("Voice Commands = " + voiceCommand );
				
				//notpad
				if(voiceCommand.equalsIgnoreCase("Open notepad")) {
					Runtime.getRuntime().exec("cmd.exe /c notepad");
				}
				else if (voiceCommand.equalsIgnoreCase("Close notepad")) {
					Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM notepad.exe");	
					}
				//chrome
				if(voiceCommand.equalsIgnoreCase("Open Chrome")) {
					Runtime.getRuntime().exec("cmd.exe /c start chrome");
				}
				else if (voiceCommand.equalsIgnoreCase("Close Chrome")) {
					Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM chrome.exe");	
					}
				
				//youtube
				if(voiceCommand.equalsIgnoreCase("Open Youtube")) {
					Runtime.getRuntime().exec("cmd.exe /c start chrome www.youtube.com");
				}
				else if (voiceCommand.equalsIgnoreCase("Close Youtube")) {
					Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM chrome.exe");	
					}
				//music
				if(voiceCommand.equalsIgnoreCase("play music")) {
					Runtime.getRuntime().exec("cmd.exe /c start chrome https://www.youtube.com/watch?v=CCJctjIO5kU");
				}
				else if (voiceCommand.equalsIgnoreCase("Close music")) {
					Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM chrome.exe");	
					}
				
				//shutdown pc
				if(voiceCommand.equalsIgnoreCase("Shutdown")) {
					 Runtime.getRuntime().exec("shutdown -s -t 0");
				}
				else {
					System.out.println("Not shutting down");
					}
				
				
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
