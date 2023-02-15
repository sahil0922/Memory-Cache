# Memory Cache

# Introduction
This project is a memory cache implementation that utilizes different eviction policies to manage the cache. The cache is implemented using a HashMap to store the key-value pairs, and an eviction policy to manage the eviction of keys from the cache. The eviction policy is determined by the Policy Name passed to the constructor.

# Getting Started
To start using the cache, you will first need to import the Cache class and the EvictionPolicy interface. The Cache class is used to create a new cache object and is responsible for managing the insertion, removal, and retrieval of key-value pairs. The EvictionPolicy interface is implemented by various eviction policy classes, such as LRU, FIFO, and LIFO.

# Using the Cache
The following is an example of how to use the cache:

java Code:
Cache cache = new Cache("LRU"); // create a new cache with LRU eviction policy

cache.put("key1", "value1"); // insert key-value pair into the cache
cache.put("key2", "value2");
cache.put("key3", "value3");

Object value = cache.get("key1"); // retrieve value of key1

cache.remove(); // remove an item from the cache based on the eviction policy

cache.clear(); // clear the cache


# Eviction Policies
This project currently supports three eviction policies:

LRU (Least Recently Used) - Evicts the least recently used item from the cache.
FIFO (First In First Out) - Evicts the oldest item that has been in the cache the longest.
LIFO (Last In First Out) - Evicts the most recently added item from the cache.
You can change the eviction policy at runtime by calling the setPolicy method on the Cache object and passing in an instance of the desired eviction policy.

# Conclusion
This project is a flexible and extensible implementation of a memory cache that allows for easy management of key-value pairs using different eviction policies. It can be easily integrated into any application that needs to cache data for faster retrieval.
