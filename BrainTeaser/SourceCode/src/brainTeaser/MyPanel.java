package brainTeaser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyPanel extends JPanel implements KeyListener {

	private int x = 29, y = 350; // Black point starting coordinates
	private int color = 2; // blue/red
	private int lastMove = 0; // variable against returning

	// GAME LAYOUT
	public Graphics2D g;

	public MyPanel() {
		
		setPreferredSize(new Dimension(524, 412));
		addKeyListener(this);
		setFocusable(true);
		requestFocusInWindow();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		final Graphics2D g2d = (Graphics2D) g;

		setBoard(g2d);
		setColorPoints(g2d);
		setCursor(g2d);
	}

	// GAME ENGINE

	// Warunek na ruch do góry
	public boolean conditionsUP(int _x, int _y) {

		if ((_x == 29 || _x == 197 || _x == 281 || _x == 449) && y > 112 || (_x == 113 || x == 365) && y > 30) {
			return true;
		}

		else {
			return false;
		}
	}

	// Warunek na ruch do dołu
	public boolean conditionsDOWN(int _x, int _y) {

		if ((_x == 113 || _x == 197 || _x == 281 || _x == 365) && y < 280 || (_x == 29 || x == 449) && y < 350) {
			return true;
		}

		else
			return false;

	}

	// Warunek na ruch w lewo
	public boolean conditionsLEFT(int _x, int _y) {

		if (_y == 28 && _x > 113 || (_y == 196 || _y == 280) && ((_x > 29 && _x <= 197) || (_x > 281 && _x <= 449))
				|| (_y == 112 && _x > 29)) {
			return true;
		}

		else
			return false;

	}

	// Warunek na ruch w prawo
	public boolean conditionsRIGHT(int _x, int _y) {

		if (_y == 28 && _x < 365 || (_y == 196 || _y == 280) && ((_x >= 29 && _x < 197) || (_x >= 281 && _x < 449))
				|| (_y == 112 && _x < 449)) {
			return true;
		}

		else
			return false;

	}

	public boolean point(int _x, int _y) {

		if (x == _x && y == _y) {
			return true;
		}
		return false;
	}

	// Funkcja ustawiająca kolor po przejsciu przez punkt
	public int setCcolor() {
		if (point(29, 322) || point(29, 154) || point(71, 280) || point(113, 154) || point(155, 196) || point(197, 154)
				|| point(239, 28) || point(323, 112) || point(365, 154) || point(323, 196) || point(407, 280)
				|| point(449, 332) || point(449, 154)) {

			return 1;
		}

		else if (point(29, 238) || point(71, 112) || point(71, 196) || point(113, 238) || point(113, 63)
				|| point(155, 112) || point(281, 154) || point(365, 63) || point(407, 196) || point(449, 238)) {

			return 2;
		}

		else
			return color;

	}

	// Zabezpiecza przed wejsciem na nieprawidłowy kolor
	public boolean checkCcolorUP(int _x, int _y) {

		if (color == 1) {

			if (_x == 29 && _y == 329 || _x == 29 && _y == 161 || _x == 113 && _y == 161 || _x == 197 && _y == 161
					|| _x == 365 && _y == 161 || _x == 449 && _y == 161 || _x == 449 && _y == 329

			) {
				return false;
			} else
				return true;

		} else {

			if (_x == 29 && _y == 245 || _x == 113 && _y == 245 || _x == 281 && _y == 161 || _x == 449 && _y == 245
					|| _x == 113 && _y == 77 || _x == 365 && _y == 77

			) {
				return false;
			} else
				return true;

		}

	}

	// Zabezpiecza przed wejsciem na nieprawidłowy kolor
	public boolean checkCcolorDOWN(int _x, int _y) {

		if (color == 1) {

			if (_x == 29 && _y == 315 || _x == 29 && _y == 147 || _x == 113 && _y == 147 || _x == 197 && _y == 147
					|| _x == 365 && _y == 147 || _x == 449 && _y == 147 || _x == 449 && _y == 315

			) {
				return false;
			} else
				return true;

		} else {

			if (_x == 29 && _y == 231 || _x == 113 && _y == 231 || _x == 281 && _y == 147 || _x == 449 && _y == 231
					|| _x == 113 && _y == 56 || _x == 365 && _y == 56

			) {
				return false;
			} else
				return true;

		}

	}

	// Zabezpiecza przed wejsciem na nieprawidłowy kolor
	public boolean checkCcolorLEFT(int _x, int _y) {

		if (color == 1) {

			if (_x == 78 && _y == 280 || _x == 162 && _y == 196 || _x == 246 && _y == 28 || _x == 330 && _y == 112
					|| _x == 330 && _y == 196 || _x == 414 && _y == 280

			) {
				return false;
			} else
				return true;

		} else {

			if (_x == 78 && _y == 196 || _x == 78 && _y == 112 || _x == 162 && _y == 112 || _x == 414 && _y == 196

			) {
				return false;
			} else
				return true;

		}

	}

	// Zabezpiecza przed wejsciem na nieprawidłowy kolor
	public boolean checkCcolorRIGHT(int _x, int _y) {

		if (color == 1) {

			if (_x == 64 && _y == 280 || _x == 148 && _y == 196 || _x == 232 && _y == 28 || _x == 316 && _y == 112
					|| _x == 316 && _y == 196 || _x == 400 && _y == 280

			) {
				return false;
			} else
				return true;

		} else {

			if (_x == 64 && _y == 196 || _x == 64 && _y == 112 || _x == 148 && _y == 112 || _x == 400 && _y == 196

			) {
				return false;
			} else
				return true;

		}

	}
	//Zabezpiecza przed wejsciem na kolor i "cofaniem"
	public boolean returningInColorPoint(int _x, int _y, int last_move) {

		if (_x == 29 && _y == 322 || _x == 29 && _y == 322 || _x == 29 && _y == 154 || _x == 71 && _y == 280
				|| _x == 113 && _y == 154 || _x == 155 && _y == 196 || _x == 197 && _y == 154 || _x == 239 && _y == 28
				|| _x == 323 && _y == 112 || _x == 365 && _y == 154 || _x == 323 && _y == 196 || _x == 407 && _y == 280
				|| _x == 449 && _y == 332 || _x == 449 && _y == 154 || _x == 29 && _y == 238 || _x == 71 && _y == 112
				|| _x == 71 && _y == 196 || _x == 113 && _y == 238 || _x == 113 && _y == 63 || _x == 155 && _y == 112
				|| _x == 281 && _y == 154 || _x == 365 && _y == 63 || _x == 407 && _y == 196 || _x == 449 && _y == 238)

		{
			if (last_move == lastMove)
				return true;
			else
				return false;
		}

		return true;
	}

	// KEY LISTENER

	@Override
	public void keyPressed(KeyEvent e) {

		int keyCode = e.getKeyCode();

		if (keyCode == KeyEvent.VK_UP && conditionsUP(x, y) && checkCcolorUP(x, y) && returningInColorPoint(x, y, 1)) {
			y = y - 7;
			color = setCcolor();
			lastMove = 1;
		} else if (keyCode == KeyEvent.VK_DOWN && conditionsDOWN(x, y) && checkCcolorDOWN(x, y)
				&& returningInColorPoint(x, y, 2)) {
			y = y + 7;
			color = setCcolor();
			lastMove = 2;
		} else if (keyCode == KeyEvent.VK_LEFT && conditionsLEFT(x, y) && checkCcolorLEFT(x, y)
				&& returningInColorPoint(x, y, 3)) {
			x = x - 7;
			color = setCcolor();
			lastMove = 3;
		} else if (keyCode == KeyEvent.VK_RIGHT && conditionsRIGHT(x, y) && checkCcolorRIGHT(x, y)
				&& returningInColorPoint(x, y, 4)) {
			x = x + 7;
			color = setCcolor();
			lastMove = 4;
		}

		repaint();
		end();
	}

	public void setBoard(Graphics g2d) {

		// PLANSZA
		g2d.setColor(new Color(139, 82, 19));

		g2d.fillRect(28, 112, 28, 252);
		g2d.fillRect(112, 28, 280, 28);
		g2d.fillRect(28, 112, 448, 28);
		g2d.fillRect(112, 28, 28, 280);
		g2d.fillRect(364, 28, 28, 280);
		g2d.fillRect(448, 112, 28, 252);
		g2d.fillRect(280, 112, 28, 196);
		g2d.fillRect(196, 112, 28, 196);
		g2d.fillRect(28, 196, 196, 28);
		g2d.fillRect(28, 280, 196, 28);
		g2d.fillRect(280, 196, 196, 28);
		g2d.fillRect(280, 280, 196, 28);
	}

	public void setColorPoints(Graphics2D g2d) {

		// CZERWONE PUNKTY
		g2d.setColor(new Color(255, 0, 0));

		g2d.fillRect(35, 329, 14, 14);
		g2d.fillRect(35, 159, 14, 14);
		g2d.fillRect(119, 159, 14, 14);
		g2d.fillRect(371, 159, 14, 14);
		g2d.fillRect(203, 159, 14, 14);
		g2d.fillRect(245, 35, 14, 14);
		g2d.fillRect(77, 287, 14, 14);
		g2d.fillRect(329, 119, 14, 14);
		g2d.fillRect(329, 203, 14, 14);
		g2d.fillRect(413, 287, 14, 14);
		g2d.fillRect(161, 203, 14, 14);
		g2d.fillRect(455, 327, 14, 14);
		g2d.fillRect(455, 159, 14, 14);

		// NIEBIESKIE PUNKTY
		g2d.setColor(new Color(0, 0, 128));

		g2d.fillRect(35, 243, 14, 14);
		g2d.fillRect(119, 72, 14, 14);
		g2d.fillRect(119, 243, 14, 14);
		g2d.fillRect(371, 72, 14, 14);
		g2d.fillRect(77, 119, 14, 14);
		g2d.fillRect(77, 203, 14, 14);
		g2d.fillRect(287, 159, 14, 14);
		g2d.fillRect(161, 119, 14, 14);
		g2d.fillRect(413, 203, 14, 14);
		g2d.fillRect(455, 243, 14, 14);
	}

	public void setCursor(Graphics g2d) {
		g2d.setColor(new Color(0, 0, 0));
		g2d.fillOval(x, y, 26, 26);
	}

	
	public void end() {
		if (x == 449 && y == 350) {
			JOptionPane.showMessageDialog(null, "Gratulacje, o to chodziło. :)");
			System.exit(0);
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
