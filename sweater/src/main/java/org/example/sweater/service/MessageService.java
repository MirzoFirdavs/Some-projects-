package org.example.sweater.service;

import org.example.sweater.controller.ControllerUtils;
import org.example.sweater.domain.Message;
import org.example.sweater.domain.User;
import org.example.sweater.domain.dto.MessageDto;
import org.example.sweater.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Value("${upload.path}")
    private String uploadPath;

    public Page<MessageDto> messageList(
            Pageable pageable,
            String filter,
            User user
    ) {
        if (filter != null && !filter.isEmpty()) {
            return messageRepository.findByTag(filter, pageable, user);
        } else {
            return messageRepository.findAll(pageable, user);
        }
    }

    public Page<MessageDto> messageListForUser(Pageable pageable, User currentUser, User author) {
        if (currentUser.equals(author)) {
            return messageRepository.findByUser(pageable, author);
        } else {
            return messageRepository.findByUser(pageable, author, currentUser);
        }
    }

    public void updateMessage(
            Message message,
            User currentUser,
            String text,
            String tag,
            MultipartFile file) throws IOException {
        if (message.getAuthor().equals(currentUser)) {
            if (!StringUtils.isEmpty(text)) {
                message.setText(text);
            }

            if (!StringUtils.isEmpty(tag)) {
                message.setTag(tag);
            }

            ControllerUtils.saveFile(message, file, uploadPath);

            messageRepository.save(message);
        }
    }

    public void deleteMessage(Long messageId) {
        messageRepository.deleteById(messageId);
    }

    public void addMessage(
            User user,
            Message message,
            BindingResult bindingResult,
            MultipartFile file,
            Pageable pageable,
            Model model) throws IOException{
        message.setAuthor(user);

        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);

            model.mergeAttributes(errorsMap);
            model.addAttribute("message", message);
        } else {
            ControllerUtils.saveFile(message, file, uploadPath);
            model.addAttribute("message", null);

            messageRepository.save(message);
        }

        Page<MessageDto> page = messageRepository.findAll(pageable, user);

        model.addAttribute("page", page);
        model.addAttribute("url", "/main");
    }
}