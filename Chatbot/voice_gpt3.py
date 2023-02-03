import openai
import pyttsx3
import speech_recognition as sr

from api_secret import API_KEY

openai.api_key = API_KEY

# Initialize the recognizer

engine = pyttsx3.init()

r = sr.Recognizer()
mic = sr.Microphone(device_index=2)
print(sr.Microphone.list_microphone_names())


# making api call

conversation = ""

user_name = "Uday"

while True:
    with mic as source:
        print("listening...")
        r.adjust_for_ambient_noise(source, duration=0.2)
        audio = r.listen(source)
        print("no longer listening...")
        try:
            user_input = r.recognize_google(audio)
            print("user input:" + user_input)
        except Exception as e:
            print(e)
            continue

        prompt = user_name + ": " + user_input + "\nBot: "
        conversation += prompt

        response = openai.Completion.create(
            engine="text-davinci-003", prompt=conversation, max_tokens=35)
        print(response)
        response_str = response["choices"][0]["text"].replace("\n", "")

        response_str = response_str.split("Bot: ")[-1]

        conversation += response_str + "\n"
        
        engine.say(conversation)

        engine.runAndWait()
