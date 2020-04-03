from __future__ import absolute_import
from __future__ import division
from __future__ import print_function

import gzip
import os
import tempfile

import numpy
from six.moves import urllib
from six.moves import xrange
import tensorflow as tf
from tensorflow.contrib.learn.python.learn.datasets.mnist import read_data_sets

# import tensorflow as tf
# import tensorflow.keras as keras
#
# (x,y), (x_test,y_test) = keras.datasets.mnist.load_data()  #numpy中的格式
# print(x.shape, y.shape)    #y为vector
# x1 = x[1,:,:]
# print(y[:4])
# y = tf.one_hot(y, depth=10)
# print(y[:4])
# print(x_test.shape,y_test.shape)

