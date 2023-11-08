package andreademasi.U2W2D3Exercise.services;


import andreademasi.U2W2D3Exercise.entities.User;
import andreademasi.U2W2D3Exercise.exceptions.BadRequestException;
import andreademasi.U2W2D3Exercise.exceptions.NotFoundException;
import andreademasi.U2W2D3Exercise.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;


    //GET authors
    public Page<User> getAllAuthors(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepo.findAll(pageable);
    }


    //POST crea un nuovo autore
    public User save(User user) {
        userRepo.findByEmail(user.getEmail()).ifPresent(u -> {
            throw new BadRequestException("L'email " + u.getEmail() + " è già utilizzata!");
        });
        user.setAvatar("http://ui-avatars.com/api/?name=" + user.getName() + "+" + user.getSurname());
        return userRepo.save(user);
    }


    //GET author by id

    public User findAuthorById(long id) {

        return userRepo.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    //PUT modifica dello specifico autore
    public User findByIdAndUpdate(long id, User user) {
        User foundUser = this.findAuthorById(id);
        foundUser.setName(user.getName());
        foundUser.setSurname(user.getSurname());
        foundUser.setEmail(user.getEmail());
        foundUser.setBirthDate(user.getBirthDate());
        foundUser.setAvatar(user.getAvatar());
        return userRepo.save(foundUser);
    }

    //DELETE dell'author
    public void findByIdAndDelete(long id) {
        User foundUser = this.findAuthorById(id);
        userRepo.delete(foundUser);
    }


}
