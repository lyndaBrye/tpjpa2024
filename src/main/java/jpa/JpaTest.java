package jpa;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.*;
import java.time.LocalDate;


import java.util.List;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.createData();
			/*test.createEmployees();*/

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		/*test.listEmployees();*/

		manager.close();
		System.out.println(".. done");
	}

	private void createData() {


		// Création d'un organisateur
		Organisateur organisateur = new Organisateur("John", "Doe","75000", "john.doe@email.com", "john.doe@email.com", "123456789",25, Sexe.HOMME);

		// Création d'un artiste
		Artiste artiste = new Artiste("Ed Sheeran", "Edward", "Chanteur Britannique");

		// Création d'un concert
		Concert concert = new Concert(50, LocalDate.now(), "Paris", 5000);
		concert.setPrix(50);


		// Création d'un utilisateur
		User user = new User("Alice", "Smith", "75000", "alice.smith@email.com", "alice.smith@email.com", "123456789",25, Sexe.FEMME);
		// Création d'un ticket pour l'utilisateur
		Ticket ticket = new Ticket(50);


		// Persist des entités dans la base de données
		manager.persist(organisateur);
		manager.persist(artiste);
		manager.persist(concert);
		manager.persist(user);
		manager.persist(ticket);


	}

	private void listData() {


		List<Concert> concerts = manager.createQuery("SELECT c FROM Concert c", Concert.class).getResultList();
		System.out.println("Nombre de concerts : " + concerts.size());

		List<Artiste> artistes = manager.createQuery("SELECT a FROM Artiste a", Artiste.class).getResultList();
		System.out.println("Nombre d'artistes : " + artistes.size());

		List<User> users = manager.createQuery("SELECT u FROM User u", User.class).getResultList();
		System.out.println("Nombre d'utilisateurs : " + users.size());

		List<Ticket> tickets = manager.createQuery("SELECT t FROM Ticket t", Ticket.class).getResultList();
		System.out.println("Nombre de tickets : " + tickets.size());


	}
}
	/*private void createEmployees() {
		int numOfEmployees = manager.createQuery("Select a From Employee a", Employee.class).getResultList().size();
		if (numOfEmployees == 0) {
			Department department = new Department("java");
			manager.persist(department);

			manager.persist(new Employee("Jakab Gipsz",department));
			manager.persist(new Employee("Captain Nemo",department));

		}
	}
	public void createArtiste(){
		int numOfArtiste=manager.createQuery("Select a From Artiste a",Artiste.class).getResultList().size();
		if(numOfArtiste==0){

		}
	}

	private void listEmployees() {
		List<Employee> resultList = manager.createQuery("Select a From Employee a", Employee.class).getResultList();
		System.out.println("num of employess:" + resultList.size());
		for (Employee next : resultList) {
			System.out.println("next employee: " + next);
		}
	}
	}
	 */
