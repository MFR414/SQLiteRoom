package id.ac.polinema.notesapp.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import id.ac.polinema.notesapp.models.User;
import id.ac.polinema.notesapp.repositories.UserRepository;

public class UserViewModel extends AndroidViewModel {
    private UserRepository repository;
    private LiveData<User> user;

    public UserViewModel(Application application) {
        super(application);
        this.repository = new UserRepository(application);
    }

    public LiveData<User> getUser(String username) {
        user = repository.getUserByUsername(username);
        return user;
    }

    public void insert(User user) {
        repository.insert(user);
    }
}
