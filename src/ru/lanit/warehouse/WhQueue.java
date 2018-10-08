package ru.lanit.warehouse;

public interface WhQueue {
	public void writeQ(int id, int qnt);
	public int[] readQ();
}
