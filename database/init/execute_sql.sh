#!/bin/bash

for file in *.sql; do
    mysql -ubible -pasdzxc bibletext < $file
done
