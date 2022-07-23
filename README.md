
# Login Back-End Manual

Sistem Login yang tersedia tidak mempunyai fitur registrasi sendiri, melainkan nantinya Administrator yang bisa memanajemen akun.


## Method

#### login()

Method untuk login dan mengembalikan nilai Integer.

```method usage
  login(username, password)
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `username` | `String` | **Required**. Bisa berupa email atau pun username |

#### Return Values

| Return Value | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `0`       | `int` | **Gagal**. Terjadi kesalahan, silahkan coba lagi. |
| `1`       | `int` | **Berhasil**. |
| `2`       | `int` | **Gagal**. Password yang anda masukkan salah.    |
| `3`       | `int` | **Gagal**. Email atau username yang anda masukkan salah.  |

## Contoh Cara Penggunaan

```java
import controller.AuthController;

public static void foo() {
  AuthController auth = new AuthController();

  String emailOrUsername = emailOrUsernameTxt.getText();
  String password = passwordTxt.getText();

  auth.login(emailOrUsername, password);
}
```

