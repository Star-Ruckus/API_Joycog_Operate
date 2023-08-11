#!/usr/bin/env bash

if [ -d /home/ubuntu/emotiv/server/ ]; then
  rm -rf /home/ubuntu/emotiv/server/
fi
mkdir -vp /home/ubuntu/emotiv/server/