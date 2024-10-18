#include <iostream>

using namespace std;

class Stack;
class Tree;
    
class Stack
{
    Tree *fact;
    Stack *next;
    public:
        void startStack(Stack *&head)
        {
            head = new Stack;
            head -> fact = NULL;
            head -> next = NULL;
        }
        
        void addStack(Stack *&head, Tree *fact)
        {
            Stack *aux = head;
            while(aux -> next)
                aux = aux -> next;
            
            aux -> next = new Stack;
            aux -> next -> fact = fact;
            aux -> next -> next = NULL;
        }
        
        bool emptyStack(Stack *head)
        {
            return head -> next == NULL;
        }
        
        Tree* removeStack(Stack *&head)
        {
            if(emptyStack(head))
            {
                cout << "Lista vacia, imposible eliminar más datos...";
                return NULL;
            }
            Stack *temporary = head, *former = head;
            while(temporary -> next != NULL)
            {
                former = temporary;
                temporary = temporary -> next;
            }
            former -> next = NULL;
            Tree *returned = temporary -> fact;
            delete temporary;
            return returned;
        }
};

class Tree
{
    Tree *left, *right;
    int fact;
    
    public:
    
    void createRoot(Tree *&root, int fact)
    {
        root = new Tree;
        root -> right = root -> left = NULL;
        root -> fact = fact;
    }
    
    void addLeftBranch(Tree *&former, int fact)//hoja = sheet, rama = branch
    {
        Tree *newBranch = new Tree;
        newBranch -> fact = fact;
        newBranch -> left = newBranch -> right = NULL;
        former -> left = newBranch;
    }
    
    void addRightBranch(Tree *&former, int fact)//hoja = sheet, rama = branch
    {
        Tree *newBranch = new Tree;
        newBranch -> fact = fact;
        newBranch -> left = newBranch -> right = NULL;
        former -> right = newBranch;
    }
    
    void createTree(Tree *&root)
    {
        int fact = 999;
        Tree *tester = NULL, *is_empty = NULL;
        cout << endl << "Para terminar ingresa un numero menor que 0";
        while(fact > 0)
        {
            cout << endl << "Dato: ";
            cin >> fact;
            if(fact > 0)
            {
                if(root == NULL)
                {
                    createRoot(root, fact);
                }
                else
                {
                    tester = is_empty = root;
                    while(is_empty != NULL && tester -> fact != fact)
                    {
                        tester = is_empty;
                        if(fact < tester -> fact)
                            is_empty = is_empty -> left;
                        else 
                            is_empty = is_empty -> right;
                    }
                    if(fact == tester -> fact)
                    {
                        cout << endl << "Dato repetido..." << endl;
                    }
                    else{
                        if(fact < tester -> fact)
                        {
                            addLeftBranch(tester, fact);
                        }
                        else 
                            addRightBranch(tester, fact);
                    }
                }
            }
        }
    }
    
    void inOrden(Tree *root)
    {
        Stack *head = NULL, object;
        object.startStack(head);
        Tree *auxiliar = root;
        while(auxiliar)
        {
            object.addStack(head, auxiliar);
            auxiliar = auxiliar -> left;
        }
        while(!object.emptyStack(head))
        {
            Tree *toShow = object.removeStack(head);
            cout << toShow -> fact << "  ";
            auxiliar = toShow -> right;
            while(auxiliar)
            {
                object.addStack(head, auxiliar);
                auxiliar = auxiliar -> left;
            }
        }
    }
};

int main()
{
    Tree object, *root = NULL;
    object.createTree(root);
    object.inorden(root);
    return 0;
}