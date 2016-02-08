import json
import pandas as pd
import re

def word_in_text(word, text):
    word = word.lower()
    text = text.lower()
    match = re.search(word, text)
    if match:
        return True
    return False

tweets_data_path = 'twitter_data.txt'

tweets_data = []
tweets_file = open(tweets_data_path, "r")
for line in tweets_file:
    try:
        tweet = json.loads(line)
        tweets_data.append(tweet)
    except:
        continue

# print len(tweets_data)

tweets = pd.DataFrame()
print tweet
#print tweets
tweets['text'] = map(lambda tweet: tweet['text'], tweets_data)
tweets['favorite_count'] = map(lambda tweet: tweet['favorite_count'], tweets_data)
tweets['retweet_count'] = map(lambda tweet: tweet['retweet_count'], tweets_data)

tweets['rape'] = tweets['text'].apply(lambda tweet: word_in_text('rape', tweet))
tweets['harassment'] = tweets['text'].apply(lambda tweet: word_in_text('harassment', tweet))
tweets['eve'] = tweets['text'].apply(lambda tweet: word_in_text('eve', tweet))

r = tweets['rape'].value_counts()[True]
h = tweets['harassment'].value_counts()[True]
e = tweets['eve'].value_counts()[True]
#for i in range(0,1500):
#    print tweets['retweet_count'][0]
#print rt
# for tweet in tweets['text']:
#     print tweet
