#include<iostream>
#include<list>
#include<string>
#include<vector>
using namespace std;

class Cake
{
	string name;
public:
	Cake() {};
	Cake(string n)
	{
		this->name = n;
	}
	string getName()
	{
		return name;
	}
};

class RecipeCake
{
	string name;
	int time;
public:
	RecipeCake() {};
	RecipeCake(string n, int t)
	{
		this->name = n;
		this->time = t;
	}
	string getName()
	{
		return name;
	}
	int getTime()
	{
		return time;
	}
};

class CakeMaker
{
public:
	CakeMaker() {};
	Cake takecom(RecipeCake r)
	{
		Cake ck(r.getName());
		return ck;
	}
}; 

class CarouselOfCakes
{
	vector<Cake>array;
	int MaxLimit = 10, LowLimit = 3;
public:
	CarouselOfCakes() {};
	bool addcake(Cake C)
	{
		bool a;
		if (array.size() < 10)
		{
			array.push_back(C);
			a = true;
		}
		else
			a = false;
		return a;
	}
	Cake getCake(string name)
	{
		Cake ck(name);
		vector<Cake>::iterator i;
		for (i = array.begin();i != array.end();i++)
		{
			if ((*i).getName() == name)
			{
				array.erase(i);
			}
	}
		return ck;
	}
	int getCurrentCapacity()
	{
		int x;
		x = array.size();
		return x;
	}
	friend class CommandTaker;
};

class CommandTaker
{
	vector<RecipeCake> carouselRecipe;
	CakeMaker cakeMaker;
	CarouselOfCakes carousel;
	bool checkCarouselOfCakes()
	{
		int y;
		bool x = false;
		y = carousel.getCurrentCapacity();
		if (y < 3)
			x = true;
		return x;
	}
	void refillCarousel()
	{
		string name;
		int time = 0;
		vector<RecipeCake>::iterator i;
		if (CommandTaker::checkCarouselOfCakes())
		{
			 i = carouselRecipe.begin();
			 do
			 {
				 i = carouselRecipe.begin();
				 name = (*i).getName();
				 Cake ck(name);
				 carousel.addcake(ck);
				 i++;

			 } while (carousel.getCurrentCapacity() < 10);
		}
	}
public:
	CommandTaker() {};
	Cake takeCommand(RecipeCake recipe)
	{
		bool gasit = false;
		vector<Cake> CL;
		if (checkCarouselOfCakes())
			refillCarousel();
		CL = getCakesFromCarousel();
		vector<Cake>::iterator i;
		for (i = CL.begin();i != CL.end();i++)
		{
			if (recipe.getName() == (*i).getName())
			{
				gasit = true;
				return carousel.getCake((*i).getName());
			}
		}
		if (!gasit)
		{
			return cakeMaker.takecom(recipe);
		}
	}
	vector<Cake> takeCommand_A(RecipeCake recipe, int nrOfCakes)
	{

	}
	vector<Cake> getCakesFromCarousel()
	{
		vector<Cake> CL;
		CL = carousel.array;
		return CL;
		
	}


};

class CommandPanel
{
	list<RecipeCake> menu;
	CommandTaker commandTaker;
public:
	CommandPanel()
	{
		RecipeCake C1("Savarina", 15);
		menu.push_back(C1);
		RecipeCake C2("Negresa", 10);
		menu.push_back(C2);
		RecipeCake C3("Tort", 20);
		menu.push_back(C3);
		RecipeCake C4("Tiramisu", 5);
		menu.push_back(C4);
	}
	void ShowProducts()
	{
		string name;
		int time;
		cout << "Lista prajituri: \n";
		list<RecipeCake>::iterator i;
		for ( i = menu.begin();i != menu.end();i++)
		{
			name =(*i).getName();
			time = (*i).getTime();
			cout << "Nume: " << name;
			cout << ", Timp necesar prepararii: " << time << "\n";
		}
	}
	void SelectProduct(string name)
	{
		Cake to(name);
		list<RecipeCake>::iterator i;
		for (i = menu.begin();i != menu.end();i++)
		{
			if (name == (*i).getName())
				to = commandTaker.takeCommand((*i));
		}

	}
	void SelectProducts(string name, int numberOfProducts)
	{

	}
	void showProductsInCarousel()
	{
		string name;

	}
};

void Meniu()
{
	CommandPanel CP;
	int opt;
	do {
		cout << "Bine ati venit, selectati optiunea dorita !\n";
		cout << "1. Afisare produse \n";
		cout << "2. Selectare produs \n";
		cout << "3. Selectati mai multe produse \n";
		cout << "4. Afisare produse deja preparate \n";
		cout << "5. Iesire \n";
		cin >> opt;
		switch (opt)
		{
		case 1:CP.ShowProducts();
			break;
		case 2:
		{
			int o;
			cout << "1. Savarina \n";
			cout << "2. Negresa \n";
			cout << "3. Tort \n";
			cout << "4. Tiramisu \n";
			cin >> o;
			switch (o)
			{
			case 1:CP.SelectProduct("Savarina");
				break;
			case 2:CP.SelectProduct("Negresa");
				break;
			case 3:CP.SelectProduct("Tort");
				break;
			case 4:CP.SelectProduct("Tiramisu");
				break;
			default:cout << "Ati apasat un buton gresit !\n";
				break;
			}
		}
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:exit(0);
			break;
		default:cout << "Optiunea introdusa de dumneavoastra nu exista!\n";
			break;
		}
	} while (1);
	
}

int main()
{
	Meniu();
}

