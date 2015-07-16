#include<stdio.h>
#include<stdlib.h>
#include<string.h>
struct node
{
	int num;
	char *desc;
	struct node *next;
};
typedef struct node node;
node *head;

void init_head(int n)
{
	char info[] = "This is head node";
	head = malloc(sizeof(node));
	head->num = n;
	head->desc = malloc(sizeof(info));
	strcpy(head->desc, info);
	head->next = malloc(sizeof(node));
	head->next = NULL;
}

void insert_node(int n)
{
	char info[] = "This is node ";
	//int sz = snprintf(NULL, 0, "%d", n);
	//char *buf = malloc(sizeof(sz+1));
	//snprintf(buf, sz, "%d", n);
	//strcat(info,buf);
	//printf("%s", info);
	node *temp = head;
	node *newnode = malloc(sizeof(node));
	newnode->num = n;
	//newnode->next = malloc(sizeof(node));
	newnode->next = NULL;
	while (temp->next != NULL)
		temp = temp->next;
	temp->next = newnode;
}

void print_list()
{
	node *temp = head;
	while (temp->next != NULL)
	{
		printf("%d\t", temp->num);
		temp = temp->next;
	}
	printf("%d\n", temp->num);
}

void delete_list()
{
	node *temp = head;
	node *temp_next = temp->next;
	while (temp->next != NULL)
	{
		temp_next = temp->next;
		//free(temp->desc);
		free(temp);
		temp = temp_next;
	}
	free (temp->desc);
	free (temp);
}

int main()
{
	init_head(1);
	insert_node(10);
	insert_node(20);
	insert_node(30);
	insert_node(40);
	print_list();
	delete_list();
	return 0;
}
