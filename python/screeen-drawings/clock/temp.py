import time

spinner = "|/-\\"

for i in range(20):
    print(f"\rLoading {spinner[i % 4]}", end="", flush=True)
    time.sleep(0.2)
