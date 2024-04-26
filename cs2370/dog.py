from transformers import pipeline
import time

t0 = time.time()

qa = pipeline("question-answering")

context = """

My family has several pets.

We have a chicken. Her name is Virginia. We got her used, so I'm not
sure what breed she is exactly.

We have a dog. Her name is Scarlett. She is a boxer mix.

And we have a pet spider. Her name is Kiwi.

"""

question = "What is my dog's name?"

answer = qa(question=question, context=context)

t1 = time.time()
print("runtime:", round(t1-t0, 2))

print(answer)
