package org.raf.lms.plugin.backendcalls;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.*;
import org.eclipse.jgit.util.FS;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class GitServerCalls {

    public static boolean cloneRepository(String path) {
        try {

            String sshPrivateKeyPath = "~/.ssh/githubrsa";
            SshSessionFactory sshSessionFactory = new JschConfigSessionFactory() {
                @Override
                protected void configure(OpenSshConfig.Host hc, Session session) {
                    session.setConfig("StrictHostKeyChecking", "no");
                }

                @Override
                protected JSch getJSch(final OpenSshConfig.Host hc, FS fs) throws JSchException {
                    JSch jsch = super.getJSch(hc, fs);
                    jsch.removeAllIdentity();
                    jsch.addIdentity(sshPrivateKeyPath);
                    return jsch;
                }
                /*
                @Override
                protected JSch createDefaultJSch(FS fs) throws JSchException {
                    JSch defaultJSch = super.createDefaultJSch(fs);
                    defaultJSch.addIdentity(sshPrivateKeyPath);
                    return defaultJSch;
                }
                */

            };

            File testFolder = new File(path);
            Git git = Git.cloneRepository()
                    .setURI("git@github.com:bdimicsurla/OOPkol.git")
                    .setDirectory(testFolder)
                    .setTransportConfigCallback(transport -> {
                        SshTransport sshTransport = (SshTransport) transport;
                        sshTransport.setSshSessionFactory(sshSessionFactory);
                    })
                    .call();

            System.out.println("Repository cloned successfully.");
            return true;
        } catch (GitAPIException e) {
            System.err.println("Error cloning repository: " + e.getMessage());
            return false;
        }
    }


    public static boolean cloneLocalRepository(String path) {


            File testFolder = new File(path);
        try {
            Git git = Git.cloneRepository()
                    .setURI("/home/bojana/Documents/nastava/raflms/proba/OOPkol/.git")
                    .setDirectory(testFolder)
                    .call();
        } catch (GitAPIException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Repository cloned successfully.");
            return true;

    }






}
