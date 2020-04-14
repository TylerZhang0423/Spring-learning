import numpy as np
import tensorflow as tf
from flask import Flask, jsonify, render_template, request
from mnist import module as model