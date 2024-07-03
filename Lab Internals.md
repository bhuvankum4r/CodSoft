```python
# 10b
# Perform Morphological Analysis. 

def simple_tokenizer(text):
    return text.split()

def simple_porter_stemmer(word):
    if word.endswith("es"):
        return word[:-2]
    elif word.endswith("ing"):
        return word[:-3]
    elif word.endswith("s"):
        return word[:-1]
    else:
        return word
    
def simple_wordnet_lemmatizer(word):
    if word.endswith("es"):
        return word[:-2]
    elif word.endswith("ing"):
        return word[:-3]
    elif word.endswith("s"):
        return word[:-1]
    else:
        return word
    
def analyze_morphemes(word, prefixes, root, suffixes):
    morphemes=[]
    for prefix in prefixes:
        if word.startswith(prefix):
            morphemes.append(prefix)
            word = word[len(prefix):]
    morphemes.append(root)
    for suffix in suffixes:
        if word.endswith(suffix):
            morphemes.append(suffix)
            word = word[:-len(suffix)]
    return morphemes

text = "The quick brown foxes are jumping over the lazy dogs" 
words = simple_tokenizer(text) 
stemmed_words = [simple_porter_stemmer(word) for word in words] 
lemmatized_words = [simple_wordnet_lemmatizer(word) for word in words] 
print("Original words:", words) 
print("Stemmed words:", stemmed_words) 
print("Lemmatized words:", lemmatized_words) 
print("\n") 
word = "misunderstanding" 
prefixes = ["mis"] 
root = "understand" 
suffixes = ["ing"] 
morphemes = analyze_morphemes(word, prefixes, root, suffixes) 
print("Word:", word) 
print("Morphemes:", morphemes) 
```

    Original words: ['The', 'quick', 'brown', 'foxes', 'are', 'jumping', 'over', 'the', 'lazy', 'dogs']
    Stemmed words: ['The', 'quick', 'brown', 'fox', 'are', 'jump', 'over', 'the', 'lazy', 'dog']
    Lemmatized words: ['The', 'quick', 'brown', 'fox', 'are', 'jump', 'over', 'the', 'lazy', 'dog']
    
    
    Word: misunderstanding
    Morphemes: ['mis', 'understand', 'ing']
    


```python
#9b
# Perform Name Entity Recognition (NER) on given text.

sentence = "Barack Obama was born in Hawaii and served as the 44th President of the United States" 
# Initialize lists 
person_list = [] 
place_list = [] 
# Extract entities and populate lists 
entities =  sentence.split() 
for entity in entities: 
    if entity  in  ["Barack",  "Obama"]: 
        person_list.append(entity) 
    elif entity in ["Hawaii", "United", "States"]: 
        place_list.append(entity) 
# Print the  lists 
print("Person List:", person_list) 
print("Place List:", place_list) 
```

    Person List: ['Barack', 'Obama']
    Place List: ['Hawaii', 'United', 'States']
    


```python
#8b
# Text Summarization (Extractive and Abstractive) 

def simple_summarization(article, num_sentences=3): 
    sentences = article.split(".") 
    sentences = [s.strip() for s in  sentences if s.strip()] 
    scores = [len(sentence) for sentence in sentences] 
    selected_sentences = sorted(zip(sentences, scores), key=lambda x: x[1], reverse=True)[:num_sentences]
    summary = [sentence for sentence, _ in selected_sentences] 
    return  '. '.join(summary) 

article = """ 
WASHINGTON - The Trump administration has ordered the military to start withdrawing roughly 7,000 troops from Afghanistan in 
the coming months, two defense officials said Thursday, an abrupt shift in the  17-year-old  war  there  and  a  decision  that  stunned  Afghan  officials,  who
said they had not been briefed on the plans. President Trump made the decision to pull the troops - about half the number the United States has in Afghanistan now - at the same time he decided to pull American forces out of Syria, one official said. The announcement came hours after Jim Mattis, the secretary of defense, said that he would resign from his position at the end of February after disagreeing with the president over his approach to policy in the Middle East. 
The whirlwind of troop withdrawals and the resignation of Mr. Mattis leave a murky picture for what is next in the United States’ longest war, and they come as Afghanistan has been troubled by spasms of violence afflicting the capital, Kabul, and other important areas. The United States has also been conducting talks with representatives of the Taliban, in what officials have described as discussions that could lead to formal talks to end the conflict. Senior Afghan officials and Western diplomats in Kabul woke up to the shock of the news on Friday morning, and many of them braced for chaos ahead. Several Afghan officials, often in the loop on security planning and decision-making, said they had received no indication in recent days that the Americans would pull troops out. The fear that Mr. Trump might take impulsive actions, however, often loomed in the background of discussions with the United States, they said. 
They saw the abrupt decision as a further sign that voices from the ground 
were lacking in the debate over the war and that with Mr. Mattis’s 
resignation, Afghanistan had lost one of the last influential 
voices in Washington who channeled the reality of the conflict into the 
White House’s deliberations. 
The president long campaigned on bringing troops home, but in 2017, at 
the request of Mr. Mattis, he begrudgingly pledged an additional 4,000 
troops to the Afghan campaign to try to hasten an end to the conflict. 
Though Pentagon officials have said the influx of forces - coupled with a 
more aggressive air campaign - was helping the war effort, Afghan forces 
continued to take nearly unsustainable levels of casualties and lose ground 
to the Taliban. 
The renewed American effort in 2017 was the first step in ensuring Afghan 
forces could become more independent without a set timeline for 
a withdrawal. 
But with plans to quickly reduce the number of American troops in the 
country, it is unclear if the Afghans can hold their own against an 
increasingly aggressive Taliban. 
Currently, American airstrikes are at levels not seen since the height 
of the war, when tens of thousands of American troops were spread 
throughout the country. 
That air support, officials say, consists mostly of propping up Afghan 
troops while they try to hold territory from a resurgent Taliban. 
""" 
# Perform summarization 
summary = simple_summarization(article) 
# Print the summary 
print(summary) 
```

    WASHINGTON - The Trump administration has ordered the military to start withdrawing roughly 7,000 troops from Afghanistan in 
    the coming months, two defense officials said Thursday, an abrupt shift in the  17-year-old  war  there  and  a  decision  that  stunned  Afghan  officials,  who
    said they had not been briefed on the plans. Though Pentagon officials have said the influx of forces - coupled with a 
    more aggressive air campaign - was helping the war effort, Afghan forces 
    continued to take nearly unsustainable levels of casualties and lose ground 
    to the Taliban. The announcement came hours after Jim Mattis, the secretary of defense, said that he would resign from his position at the end of February after disagreeing with the president over his approach to policy in the Middle East
    


```python
#7b
# Implement Sentiment Analysis using Machine Learning Classification 
data  =  ["I  love  this  product!",  "It's  terrible.",  "Neutral  statement."] 
def determine_sentiment_label(text): 
    if "love" in text.lower(): 
        return  'positive' 
    elif "terrible" in text.lower(): 
        return  'negative' 
    else: 
        return  'neutral' 
result_dict  =  {'text':  data,  'label':  [determine_sentiment_label(text)  for  text in data]} 
for  text,  label  in  zip(result_dict['text'],  result_dict['label']): 
    print(f"Text: {text}") 
    print(f"Label: {label}") 
print() 
```

    Text: I  love  this  product!
    Label: positive
    Text: It's  terrible.
    Label: negative
    Text: Neutral  statement.
    Label: neutral
    
    


```python
#6b
# Sentence completion with words or phrases using random prompts 

import random

sentence_prompts = { "She opened the door and saw a": 
                    ["beautiful garden", "mysterious figure", "bright light"], 
                    "After a long day at work, I like to relax by":  
                    ["watching  my  favorite  TV show", "going for a walk", "reading a book"]} 
input_prompt = "After a long day at work, I like to relax by" 
if input_prompt in sentence_prompts: 
    possible_completions = sentence_prompts[input_prompt] 
    print("Possible Completions:") 
    for completion in possible_completions: 
        print(f"- {input_prompt} {completion}") 
else: 
    print("Prompt not found in the dictionary.")  
    random_completion = random.choice(["enjoying a cup of tea", "listening to music", "playing video games"]) 
    print(f"- {input_prompt} {random_completion}") 

```

    Possible Completions:
    - After a long day at work, I like to relax by watching  my  favorite  TV show
    - After a long day at work, I like to relax by going for a walk
    - After a long day at work, I like to relax by reading a book
    


```python
#5b
# Implement chunking to extract Noun Phrases

import pandas as pd 
 
# Sample data  creation 
data  =  {'POS_tags':  [ [('this',  'Noun'),  ('is',  'Noun'),  ('an',  'Noun'),  ('example',  'Noun'), ('sentence',  'Noun')], 
[('another',  'Noun'),  ('example',  'Noun'),  ('sentence',  'Noun')] ]} 
df = pd.DataFrame(data) 

def simple_noun_phrase_chunking(pos_tags): 
    noun_phrases = [] 
    current_phrase = [] 
    for token, tag in pos_tags: 
        if tag in ['Noun',  'Adjective']: 
            current_phrase.append(token) 
        elif current_phrase: 
            noun_phrases.append('  '.join(current_phrase)) 
            current_phrase = [] 
            
    if current_phrase: 
        noun_phrases.append('  '.join(current_phrase)) 
    return noun_phrases 
# Apply the  function  to  generate  noun  phrases 
df['noun_phrases']  =  df['POS_tags'].apply(simple_noun_phrase_chunking) 
# Print the  dataframe 
print(df)
```

                                                POS_tags  \
    0  [(this, Noun), (is, Noun), (an, Noun), (exampl...   
    1  [(another, Noun), (example, Noun), (sentence, ...   
    
                            noun_phrases  
    0  [this  is  an  example  sentence]  
    1       [another  example  sentence]  
    


```python
#4b
# Implement Part-of-Speech (POS) Tagging.

import pandas as pd 

data  =  {'cleaned_content':  ["this  is  an  example  sentence",  "another  example sentence"]} 
df = pd.DataFrame(data) 

def simple_pos_tagging(text): 
    tokens = text.split() 
    pos_tags = [] 
    for token in tokens: 
        if  token.endswith('ing'): 
            pos_tags.append((token,  'Verb')) 
        elif  token.endswith('ly'): 
            pos_tags.append((token,  'Adverb')) 
        else: 
            pos_tags.append((token,  'Noun')) 
    return pos_tags 

df['POS_tags'] = df['cleaned_content'].apply(simple_pos_tagging)
print(df)
```

                       cleaned_content  \
    0  this  is  an  example  sentence   
    1        another  example sentence   
    
                                                POS_tags  
    0  [(this, Noun), (is, Noun), (an, Noun), (exampl...  
    1  [(another, Noun), (example, Noun), (sentence, ...  
    


```python
#3b
# Implement N-Gram model (Unigram, bigram, trigram extraction).

import pandas as pd 

data  =  {'cleaned_content':  ["this  is  an  example  sentence",  "another  example sentence"]} 
df = pd.DataFrame(data)
def generate_ngrams(text, n): 
    tokens = text.split() 
    ngrams_list  =  ['  '.join(tokens[i:i+n])  for  i  in  range(len(tokens)-n+1)] 
    return ngrams_list 

df['bigrams']  =  df['cleaned_content'].apply(generate_ngrams,  n=2) 
# Print the  dataframe 
print(df) 

df['trigrams']  =  df['cleaned_content'].apply(generate_ngrams,  n=3) 
# Print the  dataframe 
print(df) 
```

                       cleaned_content  \
    0  this  is  an  example  sentence   
    1        another  example sentence   
    
                                                 bigrams  
    0  [this  is, is  an, an  example, example  sente...  
    1              [another  example, example  sentence]  
                       cleaned_content  \
    0  this  is  an  example  sentence   
    1        another  example sentence   
    
                                                 bigrams  \
    0  [this  is, is  an, an  example, example  sente...   
    1              [another  example, example  sentence]   
    
                                                trigrams  
    0  [this  is  an, is  an  example, an  example  s...  
    1                       [another  example  sentence]  
    


```python
#2b
# Perform text pre - processing on a given corpus without using any pre - defined NLP packages.

import pandas as pd 
 
# Sample data creation  (replace  this  with  your  actual  data  loading  logic) 
data  =  {'content':  ["This  is  an  example  sentence.",  "Another  example  sentence."]} 
df = pd.DataFrame(data) 
def clean_text(text):  
    text = text.lower() 
    tokens = text.split() 
    stop_words = set(["is", "an", "the", "this", "another"])
    tokens = [word for word in tokens if word not in stop_words] 
    tokens  =  [word[:-1]  if  word.endswith('s')  else  word  for  word  in  tokens] 
    tokens  =  [word[:-1]  if  word.endswith('s')  else  word  for  word  in  tokens] 
    return  ' '.join(tokens) 
df['cleaned_content']  =  df['content'].apply(clean_text) 
print(df) 
```

                                content    cleaned_content
    0  This  is  an  example  sentence.  example sentence.
    1       Another  example  sentence.  example sentence.
    


```python
#1b
# Study of Python and basic commands to access text data. (from notepad, pdf, word documents, online)

with open('Lab 1.txt', 'r') as file:
    lines = file.readlines()
    for line in lines:
        print(line.strip())
```

    Hello my friend!
    How are you?
    Fine thank you :)
    


```python
from docx import Document
doc = Document('Lab 1.docx')
text = []
for paragraph in doc.paragraphs:
    text.append(paragraph.text)
for line in text:
    print(line)
```

    Study of Python and basic commands to access text, data (from notepad, word document, pdf and online documents)
    


```python
import PyPDF2

pdf = 'Lab 1.pdf'
with open(pdf, 'rb') as file:
    pdf_reader = PyPDF2.PdfReader(file)
    pdf_reader =  "\n".join(page.extract_text() for page in pdf_reader.pages)
print(pdf_reader)
```

    1. Study of Python and basic commands to access text, data (from notepad, word document, 
    pdf and online documents ) 
    


```python
import urllib

data = urllib.urlopen("https://filesamples.com/samples/document/txt/sample3.txt").read(20000) # read only 20 000 chars
data = data.split("\n") # then split it into lines

for line in data:
    print(line)
```


    ---------------------------------------------------------------------------

    AttributeError                            Traceback (most recent call last)

    Cell In[26], line 3
          1 import urllib
    ----> 3 data = urllib.urlopen("https://filesamples.com/samples/document/txt/sample3.txt").read(20000) # read only 20 000 chars
          4 data = data.split("\n") # then split it into lines
          6 for line in data:
    

    AttributeError: module 'urllib' has no attribute 'urlopen'



```python

```
