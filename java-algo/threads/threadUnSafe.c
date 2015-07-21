#include<pthread.h>
#include<stdio.h>
#include<stdlib.h>

#define NUM_THREADS 10
int gcount,i=0, global;

typedef struct
{
	int tid;
	int para;
	int ret;
}param;

void *threadInfo(void *parameter)
{
	param * par = (param *) parameter;
	printf("This is thread %d, parameter value is: %d\n",par->tid, par->para);
	par->para = ++(par->tid);
	return (void *) par;
}

void *mythread(void* foo)
{
	for(; i<gcount; ++i)
		 ++global;
	return NULL;
}

int main(int argc, char* argv[])
{
	gcount = 0;
	if (argc != 2)
	{
		printf("Not enough arguments\n");
		return 1;
	}
	else
	{
		gcount = atoi(argv[1]);
		printf("Global count: %d",gcount);
	}
	int *tcount = malloc(sizeof(tcount));;
	pthread_t th[NUM_THREADS * 2];
	for (*tcount = 1; *tcount <= NUM_THREADS; (*tcount)++)
	{	
		param* par = malloc(sizeof(param));
		par->tid = (*tcount)--;
		par->para = (*tcount)++;
		pthread_create(&th[*tcount-1], NULL, (void *) (threadInfo), (void *)par);
	}
	printf("This is main thread\nChild threads returned values are:\n");	
	for (*tcount = 0; *tcount < NUM_THREADS; ++(*tcount))
	{
		param* par ;
		pthread_join(th[*tcount], (void **) &par);
		printf("The parameter passed was: %d\n",par->para); 
	}
	int j = 0;
	//the global counter increment
	for (j = 10; j < NUM_THREADS * 2; ++j)
	{
		pthread_create(&th[j], NULL, mythread, NULL);
	}
	for(j=10; j < NUM_THREADS*2; ++j)
	{
		pthread_join(th[j], NULL);
	}
	printf("All threads when contributed to the global cause returned: %d\n",global);

	return 0;
}
