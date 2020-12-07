package chaplinskiy.servlet.repository.hibernate;

import chaplinskiy.servlet.model.User;
import chaplinskiy.servlet.repository.UserRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static chaplinskiy.servlet.util.HibernateSessionFactory.getSessionFactory;


public class UserRepositoryHibernate implements UserRepository {
    @Override
    public User create(User user) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();


        session.save(user);
        transaction.commit();
        session.close();
        return user;
    }

    @Override
    public User update(User user) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        User userUpdate = session.get(User.class, user.getId());
        userUpdate.setRegion(user.getRegion());
        userUpdate.setFirstName(user.getFirstName());
        userUpdate.setLastName(user.getLastName());
        userUpdate.setPosts(user.getPosts());

        session.update(userUpdate);
        transaction.commit();
        session.close();
        return userUpdate;
    }

    @Override
    public User getById(Long id) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        User user = (User) session.get(User.class, id);
        transaction.commit();
        session.close();
        return user;
    }

    @Override
    public List<User> getAll() {
        Session session = getSessionFactory().openSession();

        Transaction transaction = null;

        transaction = session.beginTransaction();
        List users = session.createQuery("from User").getResultList();

        transaction.commit();
        session.close();
        return users;
    }

    @Override
    public void deleteById(Long id) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        User user = (User) session.get(User.class, id);

        session.delete(user);
        transaction.commit();
        session.close();
    }
}
