package com.filingsystem.filingSystem.components;

import com.filingsystem.filingSystem.models.File;
import com.filingsystem.filingSystem.models.Folder;
import com.filingsystem.filingSystem.models.User;
import com.filingsystem.filingSystem.repositories.FileRepository;
import com.filingsystem.filingSystem.repositories.FolderRepository;
import com.filingsystem.filingSystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader(){}

    public void run(ApplicationArguments args) {

        User ash = new User("Ash Ketchum");
        userRepository.save(ash);


        Folder fire = new Folder("FirePokemon", ash);
        folderRepository.save(fire);

        File vulpix = new File("Vulpix", "text", "10MB", fire );
        fileRepository.save(vulpix);

        File charmander = new File ("Charmander", "ppt", "1GB", fire);
        fileRepository.save(charmander);

        File growlithe = new File( "Growlithe", "py", "5MB", fire);
        fileRepository.save(growlithe);


        Folder water = new Folder("WaterPokemon", ash);
        folderRepository.save(water);

        File totodile = new File("Totodile", "text", "10MB", water );
        fileRepository.save(totodile);

        File blastoise = new File ("Blastoise", "ppt", "1GB", water);
        fileRepository.save(blastoise);

        File psyduck = new File( "Psyduck", "java", "2GB", water);
        fileRepository.save(psyduck);

        ash.addFolder(fire);
        ash.addFolder(water);


    }
}
