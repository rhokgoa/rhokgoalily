#Import the necessary methods from tweepy library
from tweepy.streaming import StreamListener
from tweepy import OAuthHandler
from tweepy import Stream

#Geo locations
La1 = 12.934493
Ln1 = 77.538311
La2 = 13.012330
Ln2 = 77.647423

#Variables that contains the user credentials to access Twitter API
access_token = "ACCESS_TOKEN"
access_token_secret = "TOKEN-SECRET"
consumer_key = "CONSUMER-KEY"
consumer_secret = "CONSUMER-SECRET"


#This is a basic listener that just prints received tweets to stdout.
class StdOutListener(StreamListener):

    def on_data(self, data):
        print data
        return True

    def on_error(self, status):
        print status


if __name__ == '__main__':

    #This handles Twitter authetification and the connection to Twitter Streaming API
    l = StdOutListener()
    auth = OAuthHandler(consumer_key, consumer_secret)
    auth.set_access_token(access_token, access_token_secret)
    stream = Stream(auth, l)

    #This line filter Twitter Stream
    stream.filter(track=['rape', 'harassment', 'eve-teasing', 'police', 'crime'], locations=[La1,Ln1,La2,Ln2])
