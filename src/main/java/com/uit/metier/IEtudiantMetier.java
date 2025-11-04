package com.uit.metier;

import com.uit.model.Etudiant;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IEtudiantMetier extends Remote {

    Etudiant searchEtudiantByCin(String cin) throws RemoteException;
    boolean addEtudiant(Etudiant etudiant) throws RemoteException;
    boolean deleteEtudiant(String cin) throws RemoteException;
}