import spacy

# Load English tokenizer, tagger, parser, NER and word vectors
nlp = spacy.load("en_core_web_sm")

# https://spacy.io/api/span#set_extension
# extend Span object with is_stop
from spacy.tokens import Span

# if the length is 1 and the word is a stopword
stopword_checker_for_span = lambda span: (len(span) == 1 and (type(span[0]).__name__ == "Token") and span[0].is_stop)
Span.set_extension("is_stop", getter=stopword_checker_for_span)
doc = nlp(u"I")

# https://stackoverflow.com/questions/12569452/how-to-identify-numpy-types-in-python

print(spacy.__name__,"tokens","token")
print(spacy.__name__,"tokens","span")

print(type(nlp("hello world")[:]).__module__)
print(type(nlp("hello world")[:]).__name__)
print(type(nlp("hello world")[0]).__name__)
print(type(nlp("hello world")).__name__)

print(type(doc[0]).__name__)
print(type(doc[0:2]).__name__)
print(type(doc[0:2][0]).__name__)
print("??", doc[0:2])

print("is?",doc[:]._.is_stop)

