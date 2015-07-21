#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>
#define MAX_THREADS 10

pthread_mutex_t lock = PTHREAD_MUTEX_INITIALIZER;
int COUNTER;

//static int i=0, count = 0;
void *mythread()
{
	//static int i = 0;
	for (int i=0;i<COUNTER;i++);
	return (void*)NULL;
}
int main(int argc, char** argv)
{
	if (argc < 2)
	{
		printf("Not enough arguments\n");
		return 1;
	}
	else
	{
		COUNTER = atoi(argv[1]);
	}
	pthread_t threads[MAX_THREADS];
	int j = 0;
	for (int j = 0; j < MAX_THREADS; ++j)
	{
		pthread_create(&threads[j], NULL, mythread, NULL);
		//pthread_join(threads[j], NULL);
	}
	for (j = 0; j<MAX_THREADS; j++)
	{
		pthread_join(threads[j], NULL);
	}
	printf("Global counter is: %d\nvalue of i is: %d\n", count, i);
	return 0;
}
