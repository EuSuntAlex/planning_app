//package com.example.demo.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.converter.HttpMessageNotReadableException;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.time.LocalDateTime;
//import java.util.HashMap;
//import java.util.Map;
//
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//    /* ================= VALIDATION ERRORS ================= */
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex) {
//
//        Map<String, String> fieldErrors = new HashMap<>();
//        ex.getBindingResult().getFieldErrors()
//                .forEach(error ->
//                        fieldErrors.put(error.getField(), error.getDefaultMessage())
//                );
//
//        return buildBadRequestResponse(
//                "Datele trimise nu sunt valide",
//                fieldErrors
//        );
//    }
//
//    /* ================= MALFORMED JSON ================= */
//
//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    public ResponseEntity<?> handleInvalidJson(HttpMessageNotReadableException ex) {
//        return buildBadRequestResponse(
//                "Format JSON invalid",
//                null
//        );
//    }
//
//    /* ================= TYPE MISMATCH ================= */
//
////    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
////    public ResponseEntity<?> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
////        return buildBadRequestResponse(
////                "Parametru invalid: " + ex.getName(),
////                null
////        );
////    }
//
//    /* ================= FALLBACK BAD REQUEST ================= */
//
//    @ExceptionHandler(IllegalArgumentException.class)
//    public ResponseEntity<?> handleIllegalArgument(IllegalArgumentException ex) {
//        return buildBadRequestResponse(
//                ex.getMessage(),
//                null
//        );
//    }
//
//    /* ================= HELPER ================= */
//
//    private ResponseEntity<?> buildBadRequestResponse(String message, Map<String, String> details) {
//
//        Map<String, Object> response = new HashMap<>();
//        response.put("timestamp", LocalDateTime.now());
//        response.put("status", HttpStatus.BAD_REQUEST.value());
//        response.put("error", HttpStatus.BAD_REQUEST.name());
//        response.put("message", message);
//        response.put("details", details);
//
//        return ResponseEntity
//                .status(HttpStatus.BAD_REQUEST)
//                .body(response);
//    }
//}