Why Stop, Resume, Suspended method is deprecated?

STOP: Terminates the thread abruptly, No lock release, No resource clean up happens.

SUSPEND: Put the thread on hold(suspend) for temporarily. No lock is release too.

RESUME: Used to Resume the execution of Suspended thread.

Both this issue leads to deadlock situation.

JOIN:
- When JOIN method is invoked on a thread object, current thread will be blocked and waits for the specific thread to finish.

- It is helpful when we want to cordinate between threads or to ensure we complete certain task before moving ahead.

THREAD PRIORITY:
- Priorities are integer ranging from 1 to 10.
- 1 -> Low Priority
- 10 -> High Priority

- Even we set the therad priority while creation, its not guarantted to follow any specific order, it's just a hint to thread scheduler which to execute next. (but its not strict rule)

- When new thread is created, it inherits the priority of the Parent Thread.

- we can set custom priority using "setPriority(int priority)" method


DAEMON THREAD - 
Deamon means something which runs in async manner. 
Deamon thread will alive until user threads are alive.
Auto Save and garbage collector are examples of deamon thread/process.


ReadWriteLock:

Readlock - More than 1 thread can acquire the read lock.   (Shared Lock)
WriteLock - Only 1 thread can acquire the write lock.    (Exclusive Lock)



 
